class Book{
    private long bookId;
    private String bookTitle;
    private String authorName;
    private boolean availability;

    public long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    
}
