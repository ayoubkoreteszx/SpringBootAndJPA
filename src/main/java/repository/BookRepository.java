package repository;

import domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface BookRepository extends JpaRepository<Book, Long> {
    //update book
    @Modifying
    @Transactional
    @Query("update Book b set b.title = :title, b.author = :author, b.isbn = :isbn, b.price = :price where b.id = :id")
     void updateById(Long id, String title, String author, String isbn, double price);

}
