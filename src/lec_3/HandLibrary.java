package lec_3;

class Book{
    private String code;
    private String name;
    private Boolean isBorrowed = false;
    private Boolean isReturned = true;

    public void setBorrowed(){
        this.isBorrowed = true;
        this.isReturned = false;
    }

    public void setReturned(){
        this.isReturned = true;
        this.isBorrowed = false;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    public boolean getIsReturned(){
        return isReturned;
    }

    Book(String code,String name){
        this.code = code;
        this.name = name;
    }
}

class library{
    //创建图书库
    private static Book[] arr = new Book[3];

    //初始化图书库
    private static Book book_001 = new Book("001","《爱、死亡与机器人》");
    private static Book book_002 = new Book("002","《呼啸山庄》");
    private static Book book_003 = new Book("003","《Three-body Problem》");

    private static void setFirst(){
        arr[0] = book_001;
        arr[1] = book_002;
        arr[2] = book_003;
    }

    //constructor
    library(){
        setFirst();
    }

    //借出
    public static void handleBorrow(String code){
        for(int i=0;i<arr.length;i++){
            if(code == arr[i].getCode()){
                arr[i].setBorrowed();
                System.out.println(arr[i].getName() + "已借出");
            }
        }
    }

    //归还
    public static void handleReturn(String code){
        for(int i=0;i<arr.length;i++){
            if(code == arr[i].getCode()){
                arr[i].setReturned();
                System.out.println(arr[i].getName() + "已归还");
            }
        }
    }

    //查询全体状态
    public static void handleGetAll(){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getIsBorrowed()){
                System.out.println(arr[i].getName() + "已借出");
            }
            else{
                System.out.println(arr[i].getName() + "未借出");
            }
        }
    }
}

//模拟用户
public class HandLibrary{
    public static void main(String[] args){
        library mobile = new library();
        mobile.handleBorrow("001");
        mobile.handleReturn("002");
        mobile.handleBorrow("003");
        mobile.handleReturn("003");
        mobile.handleGetAll();
    }
}
