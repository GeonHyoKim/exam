package com.example.demo.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.VO.BookVO;

@Mapper
public interface BookRepository {
	
	@Delete("""
			TRUNCATE TABLE `book`
			""")
	void truncateTable();
	
	@Insert("""
				INSERT INTO `book`
					SET title = #{title}
					, author = #{author}
					, storeId = #{storeId}
			""")
	void insertBook(int storeId, String title, String author);
	
	@Select("""
			SELECT title FROM `book`
			""")
	List<BookVO> showBook();
	
	@Delete("""
			DELETE FROM `book`
				WHERE author = #{author}
			""")
	void deleteBook(String author);
	
	

}
