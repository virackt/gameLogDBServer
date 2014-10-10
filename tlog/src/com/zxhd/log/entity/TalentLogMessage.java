package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 灵宠日志
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class TalentLogMessage implements ILogCodec{
	
	public TalentLogMessage(){}
	
	public TalentLogMessage(int serverId,int iUserId,String vAccount,int lightNum,int talentId,int eventType,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.lightNum = lightNum;
					this.talentId = talentId;
					this.eventType = eventType;
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
			// 天香灯点亮数量
		private int lightNum;
			// 天赋ID
		private int talentId;
			// 天赋操作：1为天赋激活，2为天赋上阵，3为天赋下阵
		private int eventType;
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
			public void setLightNum(int lightNum){
			this.lightNum = lightNum;
		}
		public int getLightNum(){
			return this.lightNum;
		}
			public void setTalentId(int talentId){
			this.talentId = talentId;
		}
		public int getTalentId(){
			return this.talentId;
		}
			public void setEventType(int eventType){
			this.eventType = eventType;
		}
		public int getEventType(){
			return this.eventType;
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
			 								   buffer.putInt(lightNum);
			 								   buffer.putInt(talentId);
			 								   buffer.putInt(eventType);
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
				   this.lightNum = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.talentId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.eventType = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.dActionTime = IoBufferUtil.getString(buffer);
				}
			 			}
	
	//@Override
	public int getType() {
		
		return 10016;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into talentLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+lightNum+","+talentId+","+eventType+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table talentLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器Id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',lightNum int(11) comment'天香灯点亮数量',talentId int(11) comment'天赋ID',eventType int(11) comment'天赋操作：1为天赋激活，2为天赋上阵，3为天赋下阵',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,lightNum,talentId,eventType,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(lightNum);
					list.add(talentId);
					list.add(eventType);
					list.add(dActionTime);
				return list;
	}
	
}