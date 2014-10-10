package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 好友日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class FriendLogMessage implements ILogCodec{
	
	public FriendLogMessage(){}
	
	public FriendLogMessage(int serverId,int iUserId,String vAccount,int friendId,int actionType,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.friendId = friendId;
					this.actionType = actionType;
					this.dActionTime = dActionTime;
			}
	// 事件id
	private long iEventId;
			// 服务器Id
		private int serverId;
			// 用户id
		private int iUserId;
			// 帐号
		private String vAccount;
			// 对方id
		private int friendId;
			// 好友操作：1为添加好友，2为删除好友，3为申请好友数量
		private int actionType;
			// 发生时间
		private String dActionTime;
		public void setIEventId(long iEventId){
		this.iEventId = iEventId;
	}
	public long getIEventId(){
		return this.iEventId;
	}
			public void setServerId(int serverId){
			this.serverId = serverId;
		}
		public int getServerId(){
			return this.serverId;
		}
			public void setIUserId(int iUserId){
			this.iUserId = iUserId;
		}
		public int getIUserId(){
			return this.iUserId;
		}
			public void setVAccount(String vAccount){
			this.vAccount = vAccount;
		}
		public String getVAccount(){
			return this.vAccount;
		}
			public void setFriendId(int friendId){
			this.friendId = friendId;
		}
		public int getFriendId(){
			return this.friendId;
		}
			public void setActionType(int actionType){
			this.actionType = actionType;
		}
		public int getActionType(){
			return this.actionType;
		}
			public void setDActionTime(String dActionTime){
			this.dActionTime = dActionTime;
		}
		public String getDActionTime(){
			return this.dActionTime;
		}
		//@Override
	public void encode(ByteBuffer buffer){
		buffer.putLong(iEventId);
								   buffer.putInt(serverId);
			 								   buffer.putInt(iUserId);
			 								   IoBufferUtil.putString(buffer, vAccount);
			 								   buffer.putInt(friendId);
			 								   buffer.putInt(actionType);
			 								   IoBufferUtil.putString(buffer, dActionTime);
			 			}
	//@Override
	public void decode(ByteBuffer buffer){
		if(buffer.hasRemaining()){
			this.iEventId = buffer.getLong();
		}
									if(buffer.hasRemaining()){
				   this.serverId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iUserId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.vAccount = IoBufferUtil.getString(buffer);
				}
			 									if(buffer.hasRemaining()){
				   this.friendId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.actionType = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10026;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into friendLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+friendId+","+actionType+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table friendLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',friendId int(11) comment'对方id',actionType int(11) comment'好友操作：1为添加好友，2为删除好友，3为申请好友数量',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,friendId,actionType,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(friendId);
					list.add(actionType);
					list.add(dActionTime);
				return list;
	}
	
}