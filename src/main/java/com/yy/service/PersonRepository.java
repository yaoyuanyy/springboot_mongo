package com.yy.service;

import com.yy.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * <p>通过继承MongoRepository接口，我们可以非常方便地实现对一个对象的增删改查，要使用Repository的功能，先继承MongoRepository<T, TD>接口，
 * 其中T为仓库保存的bean类，TD为该bean的唯一标识的类型，一般为ObjectId。之后在service中注入该接口就可以使用，无需实现里面的方法，spring会根据定义的规则自动生成。</p>
 * <pre>{@code
 *    public interface PersonRepository extends MongoRepository<Person, ObjectId>{
 *        //这里可以添加额外的查询方法
 *    }
 * }</pre>
 * <p>但是MongoRepository实现了的只是最基本的增删改查的功能，要想增加额外的查询方法，可以按照以下规则定义接口的方法。
 * 自定义查询方法，格式为“findBy+字段名+方法后缀”，方法传进的参数即字段的值，
 * 此外还支持分页查询，通过传进一个Pageable对象，返回Page集合。</p>
 * <pre>{@code
 *     public interface PersonRepository extends MongoRepository<Person, ObjectId>{
 *         //查询大于age的数据
 *         public Page<Product> findByAgeGreaterThan(int age,Pageable page);
 *     }
 * }</pre>
 *
 * 有关此种方式的用法具体看: <em><a href="http://blog.csdn.net/laigood/article/details/7056093">http://blog.csdn.net/laigood/article/details/7056093</a></em>
 * Created by skyler on 2017/4/7.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    public List<Person> findByNameIs(String name);

    public List<Person> findByNameIsAndAgeIs(String name, int age);

    @Override
    List<Person> findAll(Sort sort);
}
