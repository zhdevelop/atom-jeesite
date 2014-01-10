/**
 * obullxl@gmail.com
 */
package com.github.obullxl.jeesite.dal.mybatis;

import com.github.obullxl.jeesite.dal.dao.UserRgtDAO;

import java.util.Map;
import java.util.List;
import com.github.obullxl.jeesite.dal.dto.UserRgtDTO;
import org.springframework.dao.DataAccessException;
import java.util.HashMap;


import com.github.obullxl.ticket.TicketService;
import com.github.obullxl.ticket.api.TicketException;
import com.github.obullxl.lang.Profiler;

/**
 * A mybatis based implementation of DAO interface <tt>com.github.obullxl.jeesite.dal.dao.UserRgtDAO</tt>.
 *
 * Generated by <tt>atom-dalgen</tt> on Fri Jan 10 20:28:42 CST 2014.
 *
 * @author obullxl@gmail.com
 */
public class MyBatisUserRgtDAO extends org.mybatis.spring.support.SqlSessionDaoSupport implements UserRgtDAO {
	/** TicketID */
	private TicketService ticketService;
	
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	public TicketService getTicketService() {
        return ticketService;
    }


	/**
	 *  Insert one <tt>UserRgtDTO</tt> object to DB table <tt>atom_user_rgt</tt>, return primary key
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>insert into atom_user_rgt(id,name,rgt_code,gmt_create,gmt_modify) values (?, ?, ?, ?, ?)</tt>
	 *
	 *	@param userRgt
	 *	@return long
	 *	@throws DataAccessException
	 */	 
    public long insert(UserRgtDTO userRgt) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER-RGT.insert");
	try {
    	if (userRgt == null) {
    		throw new IllegalArgumentException("Can't insert a null data object into db.");
    	}
    	
        try {
            userRgt.setId(this.ticketService.nextValue());
        } catch (TicketException e) {
            throw new RuntimeException("Set PrimaryKey exception.", e);
        }

        this.getSqlSession().insert("ATOM-USER-RGT.insert", userRgt);

        return userRgt.getId();
	} finally {
		Profiler.release();
	}
}

	/**
	 *  Query DB table <tt>atom_user_rgt</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_user_rgt where ((name = ?) AND (rgt_code = ?))</tt>
	 *
	 *	@param name
	 *	@param rgtCode
	 *	@return UserRgtDTO
	 *	@throws DataAccessException
	 */	 
    public UserRgtDTO find(String name, String rgtCode) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER-RGT.find");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("name", name);
        param.put("rgtCode", rgtCode);

        return this.getSqlSession().selectOne("ATOM-USER-RGT.find", param);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_user_rgt</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_user_rgt</tt>
	 *
	 *	@return List<UserRgtDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UserRgtDTO> findAll() throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER-RGT.findAll");
	try {

        return this.getSqlSession().selectList("ATOM-USER-RGT.findAll", null);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Query DB table <tt>atom_user_rgt</tt> for records.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>select * from atom_user_rgt where (name = ?)</tt>
	 *
	 *	@param name
	 *	@return List<UserRgtDTO>
	 *	@throws DataAccessException
	 */	 
    public List<UserRgtDTO> findByUser(String name) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER-RGT.findByUser");
	try {

        return this.getSqlSession().selectList("ATOM-USER-RGT.findByUser", name);

	} finally {
		Profiler.release();
	}
}
	/**
	 *  Delete records from DB table <tt>atom_user_rgt</tt>.
	 *
	 *  <p>
	 *  The sql statement for this operation is <br>
	 *  <tt>delete from atom_user_rgt where ((name = ?) AND (rgt_code = ?))</tt>
	 *
	 *	@param name
	 *	@param rgtCode
	 *	@return int
	 *	@throws DataAccessException
	 */	 
    public int delete(String name, String rgtCode) throws DataAccessException{
	Profiler.enter("DAO: ATOM-USER-RGT.delete");
	try {
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("name", name);
        param.put("rgtCode", rgtCode);

        return this.getSqlSession().delete("ATOM-USER-RGT.delete", param);
	} finally {
		Profiler.release();
	}
}
}
