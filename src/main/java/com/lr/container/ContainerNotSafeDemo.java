package com.lr.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-07 16:34
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {

        // 1. 测试多线程操作ArrayList，java.util.ConcurrentModificationException
        testConcurrentModificationException();

        List<Student> list = new ArrayList<>();
        list.add(new Student("male"));
        list.add(new Student("female"));
        list.add(new Student("female"));
        list.add(new Student("male"));
        list.add(new Student("male"));

        // 2. 使用普通for循环调用list.remove()删除元素，不推荐！
        //     2.1 没有发生，java.util.ConcurrentModificationException
        //     2.2 满足条件需要删除的元素没有完全删掉
        // testRemoveElement(list);

        // 3. 使用迭代器调用it.remove()删除元素, 推荐
        // 4. 使用迭代器调用list.remove()删除元素，java.util.ConcurrentModificationException
        // testRemoveStudentFromIterator();
    }
    private static void testConcurrentModificationException() {
        // ArrayList本质是一个Object数组,默认长度10
        List<String> list = new CopyOnWriteArrayList<>();
        // Collections.synchronizedList(new ArrayList<>());
        // new Vector<>();
        // new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        /**
         * 1. 故障现象
         *   java.util.ConcurrentModificationException
         *
         *
         * 2. 故障原因
         *    并发修改导致，参考签到案例
         *
         * 3. 解决方案
         *    3.1 new Vector<>();
         *    3.2 Collections.synchronizedList(new ArrayList<>());
         *    3.3 new CopyOnWriteArrayList<>(); 写时赋值
         *
         * 4. 优化建议
         *
         */
    }
    private static void testRemoveElement(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("male".equals(list.get(i).getGender())) {
                list.remove(i);
            }
        }
        list.forEach(System.out::println);
    }

    private static void testRemoveStudentFromIterator(List<Student> list) {
        //遍历删除,除去男生
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if ("male".equals(student.getGender())) {
                // iterator.remove();  // 测试3结论：使用迭代器的删除方法删除
                list.remove(student);  // 测试4结论： java.util.ConcurrentModificationException
            }
        }
        list.forEach(System.out::println);
    }

}


class Student {
    private String gender;
    public Student(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gender='" + gender + '\'' +
                '}';
    }
}