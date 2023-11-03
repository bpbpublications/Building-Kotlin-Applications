package chapter_05


// Demo Annotation
@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class DependencyInjector

// Demo library or a dependency
class MyLibraryTool

// Annotate constructor
class MyDemoClass @DependencyInjector constructor(dep: MyLibraryTool) {}