package lec_3;

class Books{
  private String name;
  private String code;
  public Books next = null;

  public void showBook(){
    System.out.println(this.name+"\t"+this.code);
  }

  Books(String name, String code){
    this.name = "《"+name+"》";
    this.code = code;
  }
}

public class User{
  public static void main(String[] args) {
    Books liblary = new Books("Head","000");

    Books newBook_0 = new Books("男生穿搭技巧","001");
    Books newBook_1 = new Books("nmmsl","002");
    Books newBook_2 = new Books("管理百年","003");

    newBook_0.next = newBook_1;
    newBook_1.next = newBook_2;

    Books temp = liblary.next;
    while(true){
      if(temp == null){
        temp = newBook_0;
        while (true){
          if(temp==null){
            break;
          }
          temp.showBook();
          temp = temp.next;
        }
        break;
      }
      temp.showBook();
      temp = temp.next;
    }
  }
}
