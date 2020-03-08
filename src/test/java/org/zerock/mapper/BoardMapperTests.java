package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는");
		board.setContent("New Contents");
		board.setWriter("new00");
		
		mapper.insert(board);
		
		log.info(board);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("select key");
		board.setContent("content Key");
		board.setWriter("newbi");
		
		mapper.insertSelectKey(board);
		log.info("ㅁㅁㅁㅁ"+board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		log.info(board);
	}
	@Test
	public void testDelete() {
		log.info("delete count: "+ mapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(12L);
		board.setTitle("mmo tilet");
		board.setContent("mmo contents");
		board.setWriter("user01");
		int count= mapper.update(board);
		log.info("update count: "+ count);
	}
	

}
