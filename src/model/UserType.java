package model;

//用枚举类UserType指明用户的类型有：管理员，老师和学生
public enum UserType {
    ADMIN("系统管理员",0),TEACHER("老师",1),STUDENT("学生",2);
    private String name;
    private int index;
    private UserType(String name,int index){
        this.name = name;
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    @Override//重写toString方法，将本类的对象以字符串的方式输出
    public String toString(){
        return this.name;
    }
}
