package etc.learn0727.stream;

public class Member {
    private String name;
    private String age;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    
    
    public Member(String name, String age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }
    
//    @Override
//    public boolean equals(Object obj) {
//        if(obj!=null && obj instanceof Member) {
//            Member m = (Member) obj;
//            if(name.equals(m.getName())) return true;
//        }
//        return false;
//    }
    
}