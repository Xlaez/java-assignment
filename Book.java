public class Book {
    private String title;
    private String authorNames;

    public Book(String title, String authorNames) {
        this.title = title;
        this.authorNames = authorNames;
    }

@Override
    public String toString() {
        String[] authors = authorNames.split(", "); 
        StringBuilder result = new StringBuilder("Title\n" + title + "\nAuthors\n");

        for (String author : authors) {
            result.append(author).append("\n");
        }

        return result.toString();
    }

    public static void printBooks(Book[] books) {
        System.out.println("Books :");
        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Book[] books = new Book[2];

        books[0] = new Book("Let us C", "Richtie, Dennis");
        books[1] = new Book("Thinking in Java", "Booch, Grade");

        Book.printBooks(books);
    }
}
