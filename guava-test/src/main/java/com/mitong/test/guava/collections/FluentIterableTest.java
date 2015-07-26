package com.mitong.test.guava.collections;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-26
 */
public class FluentIterableTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FluentIterableTest.class);
    private static List<Person> buildList() {
        List<Person> personList = null;
        try {
            personList = Lists.newArrayList();
            personList.add(Person.newBuilder().buildAge(1).build());
            personList.add(Person.newBuilder().buildAge(2).build());
            personList.add(Person.newBuilder().buildAge(3).build());
            personList.add(Person.newBuilder().buildAge(50).build());
        } catch (Exception e) {
            LOGGER.error("build exception", e);
        }
        return personList;
    }


    private static void testFilter() {
        Iterable<Person> personFilteredByAge = FluentIterable.from(buildList()).filter(new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getAge() <= 10;
            }
        });
        for(Person person : personFilteredByAge) {
            LOGGER.info("{}", person);
        }
    }

    public static void main(String[] args) {
        testFilter();
    }

    private static class Person {
        int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private Person(){
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .omitNullValues()
                    .add("age", age)
                    .toString();
        }

        private static class Builder {
            private Person person = new Person();
            private Builder buildAge(int age) {
                person.setAge(age);
                return this;
            }

            public Person build() {
                return person;
            }
        }
    }
}
