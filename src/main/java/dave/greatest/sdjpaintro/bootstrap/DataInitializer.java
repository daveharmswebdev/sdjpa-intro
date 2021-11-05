package dave.greatest.sdjpaintro.bootstrap;

import dave.greatest.sdjpaintro.domain.Book;
import dave.greatest.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring in action", "2323232", "Your MOM");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll()
                .forEach(book -> {
                    System.out.println("Book title: " + book.getTitle() + " -- Id: " + book.getId());
                });

    }
}
