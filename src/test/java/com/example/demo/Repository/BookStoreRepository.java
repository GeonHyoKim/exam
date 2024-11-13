package com.example.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.VO.BookStoreVO;
import com.example.demo.VO.BookVO;

@Mapper
public interface BookStoreRepository {

	@Delete("""
			TRUNCATE TABLE bookStore
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO bookStore
				SET `name` = #{name}
			""")
	void makeStore(String name);

	@Select("""
			SELECT `name` FROM bookStore
			""")
	List<BookStoreVO> showStore();

	@Update("""
			UPDATE bookStore
				SET `name` = #{name}
				WHERE id = #{id}
			""")
	void storeReName(int id, String name);

	@Select("""
			SELECT title FROM book AS b
				INNER JOIN bookStore AS bs
				ON b.storeId = bs.id
				WHERE bs.name = #{name}
			""")
	List<BookVO> showKoreItStore(String name);

}
