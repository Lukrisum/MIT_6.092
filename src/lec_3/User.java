package lec_3;

//Book类
class Book{

    private String name;

    public void setBook(String text){
        this.name = text;
    }

    public String showBook(){
        return this.name;
    }

    Book(){}
}

//标签类
class Tag{

    private String tag;

    public void setTag(String text){
        this.tag = text;
    }

    public String showTag(){
        return this.tag;
    }

    Tag(){}
}

//编码类
class Code{

    private String code;

    public void setCode(String number){
        this.code = number;
    }

    public String showCode(){
        return this.code;
    }

    Code(){}
}

//图书处理器类（具有编号，打标签功能（可以方便library类拓展分区功能））
class BookProcessor{

    class BookProcessed{
        private Book book = BookProcessor.this.book;
        private Tag tag = BookProcessor.this.tag;
        private Code code = BookProcessor.this.code;
        public BookProcessed next;

        public Book showBook(){
            return book;
        }

        public Code showCode() {
            return code;
        }

        public Tag showTag() {
            return tag;
        }

        BookProcessed(){};
    }

    private Book book = new Book();
    private Tag tag = new Tag();
    private Code code = new Code();

    public void processBook(String name,String code,String tag){
        this.book.setBook(name);
        this.tag.setTag(code);
        this.code.setCode(tag);
    }

    public BookProcessed spitBook(){
        BookProcessed newBook = new BookProcessed();
        if(newBook.book == null||newBook.tag == null || newBook.code == null){
            return null;
        }
        return newBook;
    }

    BookProcessor(){}
}

//图书批量存储即及管理类
class Repository{
    private BookProcessor A = new BookProcessor();

    public BookProcessor.BookProcessed abc(){
        A.processBook("《人间失格》","001","自传");
        return A.spitBook();
    }

    private BookProcessor.BookProcessed head = abc();

    public BookProcessor.BookProcessed getHead(){
        return head;
    }

    //无序添加
    public void addBook(BookProcessor.BookProcessed bookNode){
        BookProcessor.BookProcessed temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = bookNode;
        System.out.println(bookNode.showTag().showTag()+" "+bookNode.showBook().showBook()+" "+"成功归还！");
    }

    //删除节点
    public void delBook(BookProcessor.BookProcessed bookNode){
        BookProcessor.BookProcessed temp = head;
        boolean flag = false;
        while (true){
            if(temp==null){
                break;
            }
            if(temp.showCode() == bookNode.showCode()){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
            System.out.println(bookNode.showCode()+" "+bookNode.showBook().showBook()+" "+"成功借出！");
            return;
        }
        System.out.println("编号为"+" "+bookNode.showCode()+" 的书不存在！");
    }

    //搜索(目前仅仅支持索引暴力搜索，待开发算法)
    public void searchBook(String code){
        BookProcessor.BookProcessed temp = head;
        boolean flag = false;
        while(true){
            if(temp==null){
                break;
            }
            if(temp.showCode().showCode() == code){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println(temp.showCode()+" "+temp.showBook().showBook());
            return;
        }
        System.out.println("编号为"+" "+temp.showCode()+"的书不存在！");
    }
}

//library类
class library{

    //购进图书处理器具
    private BookProcessor newMachine = new BookProcessor();

    //处理书籍
    public BookProcessor.BookProcessed process(String name,String code,String tag){
        newMachine.processBook(name,code,tag);
        BookProcessor.BookProcessed newBook = newMachine.spitBook();
        return newBook;
    }

    //创建书库
    private Repository admin_mine = new Repository();

    //书籍入库
    public void handleReturn(String name,String code,String tag){
        admin_mine.addBook(this.process(name,code,tag));
    }

    //书籍出库
    public void handleBorrow(String name,String code,String tag){
        admin_mine.delBook(this.process(name,code,tag));
    }

    //搜索书籍
    public void searchBook(String code){
        admin_mine.searchBook(code);
    }
}

//模拟用户
public class User{
    public static void main(String[] args){
        library me = new library();
        me.handleReturn("《爱、死亡与机器人》","000","奇幻、哲学");
        me.handleBorrow("《爱、死亡与机器人》","000","奇幻、哲学");
    }
}
