

是一些面试题或者典型例题

练 习
1.请从键盘随机输入10个整数保存到List中，并按倒序、从大
到小的顺序显示出来
2.请把学生名与考试分数录入到集合中，并按分数显示前三名
成绩学员的名字。
TreeSet(Student(name,score,id));

4. 对一个Java源文件中的关键字进行计数。
提示：Java源文件中的每一个单词，需要确定该单词是否是一个关键字。为
了高效处理这个问题，将所有的关键字保存在一个HashSet中。用contains()
来测试。
File file = new File("Test.java");
Scanner scanner = new Scanner(file);
while(scanner.hasNext()){
String word = scanner.next();
System.out.println(word);
}