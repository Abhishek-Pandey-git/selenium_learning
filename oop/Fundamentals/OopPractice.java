package Fundamentals;

class Child {
     public int var1=23;
    public int var2=33;

   public Child(int var1,int var2){
    this.var1=var1;
    this.var2=var2;
   }

   public Child(){

   }

   public void printValues(){
    System.out.println(var1+ " "+var2);
   }
    
}

class Child2 extends Child{
    int var1=34;
    int x=22;

    public Child2(int var1,int x){
        super(30,30);
        this.var1=var1;
        this.x=x;
    }

    public void usingSuper(){
       
        super.printValues();
        System.out.println(this.var1+" "+super.var1);
    }
}

public class OopPractice{
    
   public static void main(String[] args) {
    Child2 ch=new Child2(22, 22);
    ch.usingSuper();
    
   }
}


