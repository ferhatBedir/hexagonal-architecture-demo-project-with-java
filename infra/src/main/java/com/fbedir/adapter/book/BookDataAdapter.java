package com.fbedir.adapter.book;

import com.fbedir.adapter.book.entity.BookEntity;
import com.fbedir.adapter.book.repository.BookRepository;
import com.fbedir.author.model.Author;
import com.fbedir.book.model.Book;
import com.fbedir.book.port.BookDataPort;
import com.fbedir.book.usecase.BookCreateUseCase;
import com.fbedir.book.usecase.BookUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookDataAdapter implements BookDataPort {

    private final BookRepository bookRepository;

    @Override
    public void create(BookCreateUseCase useCase) {
        //todo the author must check here. If there is not the author, exception should be thrown
        //@formatter:off
        var newBook = BookEntity.builder()
                                     .createdAt(LocalDateTime.now())
                                     .name(useCase.name())
                                     .quantity(useCase.quantity())
                                     .authorEntity(null)
                                     .build();
        //@formatter:on
        bookRepository.save(newBook);
    }

    @Override
    public Book update(BookUpdateUseCase useCase) {
        //todo the author must check here. If there is not the author, exception should be thrown
        //todo kendi exception olabilir.
        var book = bookRepository.findById(useCase.id()).orElseThrow(() -> new RuntimeException("Book not found"));

        book.setUpdatedAt(LocalDateTime.now());
        book.setName(useCase.name());
        book.setQuantity(useCase.quantity());

        bookRepository.save(book);

        return null;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book lendBook(Long id) {
        //todo kendi exception olabilir.
        var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        Integer quantity = book.getQuantity();

        if (quantity == 0) {
            //todo I can throw exception
        }

        quantity -= 1;

        book.setQuantity(quantity);

        var updatedBook = bookRepository.save(book);

        //@formatter:off
        return new Book(updatedBook.getId(),
                        updatedBook.getName(),
                        updatedBook.getQuantity(),
                        new Author(updatedBook.getAuthorEntity().getId(),
                                   updatedBook.getAuthorEntity().getName(),
                                   updatedBook.getAuthorEntity().getSurname()));
        //@formatter:on

    }
}
