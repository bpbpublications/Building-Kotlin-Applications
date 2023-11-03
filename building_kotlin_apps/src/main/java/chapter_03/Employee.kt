package chapter_03

class Employee(var name:String) {
    constructor(name: String, supervisor: Manager):this(name) {}
}