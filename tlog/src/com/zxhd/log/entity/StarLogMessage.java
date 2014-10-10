package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 星星日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class StarLogMessage implements ILogCodec{
	
	public StarLogMessage(){}
	
	public StarLogMessage(int serverId,int iUserId,String vAccount,int numOfStarBefore,int numOfStarFinal,int actionType,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.numOfStarBefore = numOfStarBefore;
					this.numOfStarFinal = numOfStarFinal;
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
			// 变化前星星数量
		private int numOfStarBefore;
			// 变化后星星数量
		private int numOfStarFinal;
			// 变化原因：1为获得，2为消耗
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
			public void setNumOfStarBefore(int numOfStarBefore){
			this.numOfStarBefore = numOfStarBefore;
		}
		public int getNumOfStarBefore(){
			return this.numOfStarBefore;
		}
			public void setNumOfStarFinal(int numOfStarFinal){
			this.numOfStarFinal = numOfStarFinal;
		}
		public int getNumOfStarFinal(){
			return this.numOfStarFinal;
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
			 								   buffer.putInt(numOfStarBefore);
			 								   buffer.putInt(numOfStarFinal);
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
				   this.numOfStarBefore = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.numOfStarFinal = buffer.getInt();
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
		
		return 10028;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into starLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+numOfStarBefore+","+numOfStarFinal+","+actionType+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table starLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',numOfStarBefore int(11) comment'变化前星星数量',numOfStarFinal int(11) comment'变化后星星数量',actionType int(11) comment'变化原因：1为获得，2为消耗',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,numOfStarBefore,numOfStarFinal,actionType,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(numOfStarBefore);
					list.add(numOfStarFinal);
					list.add(actionType);
					list.add(dActionTime);
				return list;
	}
	
}