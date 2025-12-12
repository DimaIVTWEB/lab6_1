package io.jfxdevelop.lab6_1;

public class Student {
    private int id;
    private String name;
    private int age;
    private String groupName;

    public Student(int id, String name, int age, String groupName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.groupName = groupName;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGroupName() { return groupName; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    @Override
    public String toString() {
        return "ID: " + id + ", Имя: " + name + ", Возраст: " + age + ", Группа: " + groupName;
    }
}