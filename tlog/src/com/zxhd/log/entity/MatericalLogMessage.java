package com.zxhd.log.entity;
import com.zxhd.log.core.ILogCodec;
import com.zxhd.log.file.LogNameUtil;
import com.zxhd.log.util.LogFileUtil;
import com.zxhd.log.util.IoBufferUtil;
import org.apache.mina.common.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
/**
  * 材料日志（包含碎片 图纸 图纸碎片）
  *	@author VIC
  * 此类用工具生成，不可修改
  */
public class MatericalLogMessage implements ILogCodec{
	
	public MatericalLogMessage(){}
	
	public MatericalLogMessage(int serverId,int iUserId,String vAccount,int iUserLv,int matericalId,int matericalNum,int eventType,String dActionTime){
					this.serverId = serverId;
					this.iUserId = iUserId;
					this.vAccount = vAccount;
					this.iUserLv = iUserLv;
					this.matericalId = matericalId;
					this.matericalNum = matericalNum;
					this.eventType = eventType;
					this.dActionTime = dActionTime;
			}
	// 事件id
	private long iEventId;
			// 服务器id
		private int serverId;
			// 用户id
		private int iUserId;
			// 帐号
		private String vAccount;
			// 战队等级
		private int iUserLv;
			// 材料ID
		private int matericalId;
			// 材料数量
		private int matericalNum;
			// 1为副本掉落获得，4为背包出售后消失，5为招魂台获得，6为商城购买，7合成后消失，8为普通活动副本，9为王者试炼；0为其他类型
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
			public void setIUserLv(int iUserLv){
			this.iUserLv = iUserLv;
		}
		public int getIUserLv(){
			return this.iUserLv;
		}
			public void setMatericalId(int matericalId){
			this.matericalId = matericalId;
		}
		public int getMatericalId(){
			return this.matericalId;
		}
			public void setMatericalNum(int matericalNum){
			this.matericalNum = matericalNum;
		}
		public int getMatericalNum(){
			return this.matericalNum;
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
			 								   buffer.putInt(iUserLv);
			 								   buffer.putInt(matericalId);
			 								   buffer.putInt(matericalNum);
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
				   this.iUserLv = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.matericalId = buffer.getInt();
				}
			 									if(buffer.hasRemaining()){
				   this.matericalNum = buffer.getInt();
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
		
		return 10004;
	}

	//@Override
	public String getFileName() {
		return LogNameUtil.getLogName(this.getClass().getSimpleName());
	}

	//@Override
	public String getUpdateSql() {
		return "insert into matericalLog values(" + iEventId + "," + serverId+","+iUserId+","+"'" + vAccount+ "'"+","+iUserLv+","+matericalId+","+matericalNum+","+eventType+","+"'" + dActionTime+ "'" + ")";
	}

	//@Override
	public String getCreateTableSql() {
		return "create table matericalLog (iEventId bigint(20) comment '事件id', serverId int(11) comment'服务器id',iUserId int(11) comment'用户id',vAccount varchar(45) comment'帐号',iUserLv int(11) comment'战队等级',matericalId int(11) comment'材料ID',matericalNum int(11) comment'材料数量',eventType int(11) comment'1为副本掉落获得，4为背包出售后消失，5为招魂台获得，6为商城购买，7合成后消失，8为普通活动副本，9为王者试炼；0为其他类型',dActionTime timestamp comment'发生时间',primary key(iUserId, serverId, iEventId))ENGINE=MyISAM DEFAULT CHARSET=utf8;" ;
	}

	//@Override
	public String getFileContent() {
		return LogFileUtil.convertObjects2String(serverId,iUserId,vAccount,iUserLv,matericalId,matericalNum,eventType,dActionTime);
	}
	
	public List<Object> list(){
		List<Object> list = new ArrayList<Object>();
		list.add(iEventId);
					list.add(serverId);
					list.add(iUserId);
					list.add(vAccount);
					list.add(iUserLv);
					list.add(matericalId);
					list.add(matericalNum);
					list.add(eventType);
					list.add(dActionTime);
				return list;
	}
	
}