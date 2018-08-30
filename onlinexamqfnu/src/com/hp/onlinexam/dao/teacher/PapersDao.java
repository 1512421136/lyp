package com.hp.onlinexam.dao.teacher;

import java.util.List;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.util.DBUtil;

public class PapersDao implements IPapersDao{
	private DBUtil db = new DBUtil();

	@Override
	public int save(Paper paper) {
		// TODO Auto-generated method stub
		String sql = "insert into papers (testIds,courseId,time,score,wrongIds,wrongAnsIds,studentId) values(?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {paper.getTestId(),paper.getCourseId(),paper.getTime(),paper.getScore(),paper.getWrongQueId(),paper.getWrongAns(),paper.getStudentId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperCompare(int teaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
