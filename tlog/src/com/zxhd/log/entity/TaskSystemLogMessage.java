package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 任务系统日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class TaskSystemLogMessage implements ILogCodec{
	
	public TaskSystemLogMessage(){}
	
	public TaskSystemLogMessage(int serverId,int iUserId,String vAccount,int iTaskId,int iTaskChainId,int iTaskChainOrder,int ilogType,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iTaskId = iTaskId;
					this.iTaskChainId = iTaskChainId;
					this.iTaskChainOrder = iTaskChainOrder;
					this.ilogType = ilogType;
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
			// 任务ID
		private int iTaskId;
			// 任务链ID
		private int iTaskChainId;
			// 任务链顺序
		private int iTaskChainOrder;
			// 任务记录类型,1表示完成，2表示领取，3表示出现任务
		private int ilogType;
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
			public void setITaskId(int iTaskId){
			this.iTaskId = iTaskId;
		}
		public int getITaskId(){
			return this.iTaskId;
		}
			public void setITaskChainId(int iTaskChainId){
			this.iTaskChainId = iTaskChainId;
		}
		public int getITaskChainId(){
			return this.iTaskChainId;
		}
			public void setITaskChainOrder(int iTaskChainOrder){
			this.iTaskChainOrder = iTaskChainOrder;
		}
		public int getITaskChainOrder(){
			return this.iTaskChainOrder;
		}
			public void setIlogType(int ilogType){
			this.ilogType = ilogType;
		}
		public int getIlogType(){
			return this.ilogType;
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
			 								   buffer.putInt(iTaskId);
			 								   buffer.putInt(iTaskChainId);
			 								   buffer.putInt(iTaskChainOrder);
			 								   buffer.putInt(ilogType);
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
				   this.iTaskId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iTaskChainId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iTaskChainOrder = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.ilogType = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10014;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into taskSystemLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iTaskId+","+iTaskChainId+","+iTaskChainOrder+","+ilogType+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table taskSystemLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iTaskId int(11) comment'任务ID',iTaskChainId int(11) comment'任务链ID',iTaskChainOrder int(11) comment'任务链顺序',ilogType int(1) comment'任务记录类型,1表示完成，2表示领取，3表示出现任务',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iTaskId,iTaskChainId,iTaskChainOrder,ilogType,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iTaskId);
					list.add(iTaskChainId);
					list.add(iTaskChainOrder);
					list.add(ilogType);
					list.add(dActionTime);
				return list;
	}
	
}