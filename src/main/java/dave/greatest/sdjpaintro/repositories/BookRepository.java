package dave.greatest.sdjpaintro.repositories;

import dave.greatest.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
