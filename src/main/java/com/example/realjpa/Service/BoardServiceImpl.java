package com.example.realjpa.Service;

import com.example.realjpa.domain.Board;
import com.example.realjpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepo;


    @Override
    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepo.findAll();
        //findAll함수를 이용하여 board테이블의 모든데이터를 가져와 리턴함.
    }


    @Override
    public void insertBoard(Board board) {
        boardRepo.save(board);
        // 매개변수로 받은 엔티티를 boardReposiotry의 save를 통해 영속화
    }

    @Override
    public Board getBoard(Board board) {
        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard=boardRepo.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepo.deleteById(board.getSeq());
    }
}
