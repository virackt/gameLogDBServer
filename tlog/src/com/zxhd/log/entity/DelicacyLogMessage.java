package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 江湖美食日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class DelicacyLogMessage implements ILogCodec{
	
	public DelicacyLogMessage(){}
	
	public DelicacyLogMessage(int serverId,int iUserId,String vAccount,int physicalAdd,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.physicalAdd = physicalAdd;
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
			// 体力增加数量
		private int physicalAdd;
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
			public void setPhysicalAdd(int physicalAdd){
			this.physicalAdd = physicalAdd;
		}
		public int getPhysicalAdd(){
			return this.physicalAdd;
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
			 								   buffer.putInt(physicalAdd);
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
				   this.physicalAdd = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10022;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into delicacyLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+physicalAdd+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table delicacyLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',physicalAdd int(11) comment'体力增加数量',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,physicalAdd,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(physicalAdd);
					list.add(dActionTime);
				return list;
	}
	
}