import org.example.domain.*;
import org.example.exceptions.BorrowLimitException;
import org.example.exceptions.ItemNotAvailableException;
import org.example.util.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    private Library library;
    private Student student;
    private Book book;

    @BeforeEach
    void setUp() {
        library = new Library();
        student = new Student("Alice");
        book = new Book("Java Book", ItemStatus.IN_STORE, "1234567890123", "John", "Education");
        library.addUser(student);
        library.addItem(book);
    }

    @Test
    @DisplayName("Student successfully borrows a book")
    void testBorrowItem1() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        Assertions.assertEquals(ItemStatus.BORROWED, book.getStatus());
    }

    @Test
    @DisplayName("Borrowed items list increases after borrowing")
    void testBorrowItem2() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        Assertions.assertEquals(1, student.getBorrowedItems().size());
    }

    @Test
    @DisplayName("Student successfully returns a book")
    void testReturnItem1() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        library.returnItem(student, book);
        Assertions.assertEquals(ItemStatus.IN_STORE, book.getStatus());
    }

    @Test
    @DisplayName("Borrowed items list decreases after returning")
    void testReturnItem2() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        library.returnItem(student, book);
        Assertions.assertEquals(0, student.getBorrowedItems().size());
    }

    @Test
    @DisplayName("Borrowing an already borrowed item throws ItemNotAvailableException")
    void testBorrowAlreadyBorrowedItem1() throws BorrowLimitException, ItemNotAvailableException {
        library.borrowItem(student, book);
        Teacher teacher = new Teacher("Bob");
        Assertions.assertThrows(ItemNotAvailableException.class, () -> library.borrowItem(teacher, book));
    }

    @Test
    @DisplayName("Borrowing beyond limit throws BorrowLimitException")
    void testBorrowLimitException1() {
        for (int i = 0; i < 5; i++) {
            Book b = new Book("Book " + i, ItemStatus.IN_STORE, "123456789000" + i, "Author", "Genre");
            library.addItem(b);
            try {
                library.borrowItem(student, b);
            } catch (Exception e) {
                Assertions.fail("Should not throw yet");
            }
        }
        Book extraBook = new Book("Extra Book", ItemStatus.IN_STORE, "1234567890999", "Author", "Genre");
        library.addItem(extraBook);
        Assertions.assertThrows(BorrowLimitException.class, () -> library.borrowItem(student, extraBook));
    }

    @Test
    @DisplayName("Valid ISBN with 13 digits")
    void testValidISBN1() {
        boolean actual = Validation.isValidISBN("1234567890123");
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Invalid ISBN with less than 13 digits")
    void testValidISBN2() {
        boolean actual = Validation.isValidISBN("12345");
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Valid non-empty string")
    void testIsNotEmpty1() {
        boolean actual = Validation.isNotEmpty("hello");
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Invalid empty string")
    void testIsNotEmpty2() {
        boolean actual = Validation.isNotEmpty("");
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Recursive search finds item by title")
    void testRecursiveSearch1() {
        Item result = library.recursiveSearch(library.getItems(), "Java Book", 0);
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("Recursive search returns null when item not found")
    void testRecursiveSearch2() {
        Item result = library.recursiveSearch(library.getItems(), "Unknown Book", 0);
        Assertions.assertNull(result);
    }
}