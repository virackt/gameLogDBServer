package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 新手引导
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class UserGuideLogMessage implements ILogCodec{
	
	public UserGuideLogMessage(){}
	
	public UserGuideLogMessage(int serverId,int iUserId,String vAccount,int iSceneId,int iModelId,int iSceneStep,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iSceneId = iSceneId;
					this.iModelId = iModelId;
					this.iSceneStep = iSceneStep;
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
			// 场景ID
		private int iSceneId;
			// 模块Id
		private int iModelId;
			// 场景引导完成的步数
		private int iSceneStep;
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
			public void setISceneId(int iSceneId){
			this.iSceneId = iSceneId;
		}
		public int getISceneId(){
			return this.iSceneId;
		}
			public void setIModelId(int iModelId){
			this.iModelId = iModelId;
		}
		public int getIModelId(){
			return this.iModelId;
		}
			public void setISceneStep(int iSceneStep){
			this.iSceneStep = iSceneStep;
		}
		public int getISceneStep(){
			return this.iSceneStep;
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
			 								   buffer.putInt(iSceneId);
			 								   buffer.putInt(iModelId);
			 								   buffer.putInt(iSceneStep);
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
				   this.iSceneId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iModelId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.iSceneStep = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10034;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into userGuideLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iSceneId+","+iModelId+","+iSceneStep+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table userGuideLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iSceneId int(11) comment'场景ID',iModelId int(11) comment'模块Id',iSceneStep int(11) comment'场景引导完成的步数',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iSceneId,iModelId,iSceneStep,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iSceneId);
					list.add(iModelId);
					list.add(iSceneStep);
					list.add(dActionTime);
				return list;
	}
	
}