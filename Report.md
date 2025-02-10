# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   
   > A file type has values seperated by comma ','.
   
2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

   > Because this let us can change the data type into Linked list or Array List easily. And we also can store HourlyEmployee and SalaryEmployee. Not just limited in ArrayList and HourlyEmployee. Shortly, we can achieve polymorphism.[^1]

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

   > has-a

4. Can you provide an example of a has-a relationship in your code (if one exists)?
   >A "has-a" relationship exists in `SalaryEmployee` class because it contains an instance of `PayStub` when it calls `runPayroll()`.


5. Can you provide an example of an is-a relationship in your code (if one exists)?
   >A "is-a" relationship exists in where `SalaryEmployee` and `HourlyEmployee` implements the `IEmployee` interface.


6. What is the difference between an interface and an abstract class?

   > Interface just force the class who implement it to achieve all actions in it. But itself does not achieve the actions. 
   >
   > An abstract class provide the content which the child class can use directly or rewrite. And itself do not force childs to do anything.[^2]


7. What is the advantage of using an interface over an abstract class?
   >The interface let unrelational classes to share the same behaviour.


8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
   >Not valid.
   >
   >Because Java Generics (`<>`) only work with reference types, not primitive types (`int`, `double`, etc.).
   >
   >We can fix it like this `List<Integer> numbers = new ArrayList<Integer>();`


9. Which class/method is described as the "driver" for your application? 
   >The `main` method inside the `PayrollGenerator` class.

10. How do you create a temporary folder for JUnit Testing? 
    >In JUnit 5, we can use the `@TempDir` annotation. This ensures that the folder is automatically created before the test and deleted afterward.[^3]






## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

>To achieve salary equity, payroll system should include additional data which includes demographic information such as gender, race/ethnicity, years of experience, education level, job role, and geographic location. 
>
>And a new module could be added to the payroll system to generate equity audit reports, flagging employees who earn significantly less than peers with comparable qualifications and roles. This system should analyze salaries at multiple stages: when new hires are onboarded, during annual salary adjustments, and after major promotions. To account for pretax benefits that could mask disparities, salary analysis should be performed using base salary (before deductions and bonuses) rather than total compensation. 
>
>Furthermore, anonymized salary benchmarking against industry standards can help ensure competitive and fair pay structures. These enhancements will enable the company to address salary inequities in real-time rather than relying solely on retrospective employee feedback.



## References

[^1]: Oracle Java Documentation - List. [https://docs.oracle.com/javase/8/docs/api/java/util/List.html](https://docs.oracle.com/javase/8/docs/api/java/util/List.html). Accessed: 2025-02-10.



[^2]: Oracle Java Interface Guide - Interface. https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html. Accessed: 2025-02-10.



[^3]: JUnit 5 User Guide. https://www.baeldung.com/junit-5-temporary-directory. Accessed: 2025-02-10.
