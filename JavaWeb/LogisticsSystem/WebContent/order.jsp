<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>在线填单 - 我要寄件</title>
	<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./js/order.js"></script>
	<link href="./css/order.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.html" />
	
	<div class="main_div">
		<div class="form_div">
			<form action="./Order" method="post">
			<div id="sender_div">
				<div class="input_div">
					<lable >寄件方:</lable><br>
					<input type="text" value="" name="sender" placeholder="请填写寄件方名称"/>
				</div>
				<div class="input_div">
					<lable >寄件方电话:</lable><br>
					<input type="text" value="" name="senderphone" placeholder="请填写寄件方联系电话"/>
				</div>
				<div class="input_div">
					<lable >寄件方地区:</lable>
					<select class="sheng">
						<option value="" disabled selected hidden>-省-</option>
						<jsp:include page="regions-level1.html" />
					</select>
					<select class="shi" disabled="disabled">
						<option  value="" disabled selected hidden>-市-</option>
					</select>
					<select class="qu" name="srcregion" disabled="disabled">
						<option value="" disabled selected hidden>-区-</option>
					</select><br>
					
					<input type="text" name="srcmergername" placeholder="请选择寄件方地区"  readonly="readonly" />
				</div>
				<div class="input_div">
					<lable >寄件方详细地址:</lable><br>
					<input type="text" name="senderaddr" placeholder="请填写寄件方详细地址" style="width:300px"/>
				</div>
			</div>	
			<div id="recipient_div">
				<div class="input_div">
					<lable >收件方:</lable><br>
					<input type="text" value="" name="recipient" placeholder="请填写收件方名称"/>
				</div>
				<div class="input_div">
					<lable >收件方电话:</lable><br>
					<input type="text" value="" name="recipientphone" placeholder="请填写收件方联系电话"/>
				</div>
				<div class="input_div">
					<lable >收件方地区:</lable>
					<select class="sheng">
						<option value="" disabled selected hidden>-省-</option>
						<jsp:include page="regions-level1.html" />
					</select>
					<select class="shi" disabled="disabled">
						<option  value="" disabled selected hidden>-市-</option>
					</select>
					<select class="qu" name="desregion" disabled="disabled">
						<option value="desr" disabled selected hidden>-区-</option>
					</select><br>
					
					<input type="text" value="" name="desmergername" placeholder="请选择收件方地区"  readonly="readonly" />
				</div>
				<div class="input_div">
					<lable >收件方详细地址:</lable><br>
					<input type="text" value="" name="recipientaddr" placeholder="请填写收件方详细地址" style="width:300px"/>
				</div>
			</div>	
			<div >
				查询码:
				<select name="querycode" class="querycode" >
					<option value="no"selected >不使用</option>
					<option value ="staticcode" >设置查询码</option>
				</select>
				<input type="hidden" name="code" placeholder="请填写查询码" style="width:95px"/>
				<input type="submit" value="提交" style="width:100px;float:right"/>
			</div>
			</form>
		</div>
		<div class="notes_div">
					<span class="warning-title"><img src="./img/warning.png" width="25" height="25"> <b>快递服务协议：</b></span><br>
					<b>一、快递服务法律关系和服务范围：</b>本协议经寄件人签名、收寄员收取快件后成立生效，由在运单上印制企业名称全称或者盖章的收寄快递企业与寄件人建立快递服务合同关系并提供快递服务（代收货款须另签协议），承诺及时安全地交付快件。<br>
					<b>二、运单填写：</b>寄件人须用力工整地手写或打印运单，清楚、准确、完整、如实地填写寄件人和收件人的姓名、地址、联系电话以及内件品名、数量、付费方式和赔偿约定（保价时还须填写申报内件价值即保价价值）等内容并签名。寄件人不得隐瞒或虚报内件的性质、品名、数量、内件价值等真实情况，否则须承担相应责任 。<br>
					<b>三、包装：</b>寄件人应根据内件性质，在满足装卸、运送、派送投递等快递环节要求的情况下对快件进行必要和足够的包装，并保证快件不会污染和损害其他快件。<br>
					<b>四、禁寄：</b>寄件人承诺不得交寄以下禁寄物品和危险品（详细可查阅国家邮政局《禁寄物品指导目录及处理办法》），违者须承担相应责任：
						1、武器、弹药及仿真武器、管制刀具；2、易燃、易爆、易腐蚀性物品；3、放射性物质；4、烈性毒药、生化制品、传染性物品；5、毒品、麻醉药物；6、危害国家安全和社会政治稳定以及淫秽的出版物、宣传品、印刷品、光盘制品等；7、妨害公共卫生的物品；8、包装不妥，可能危害人身和其他快件的物品；9、流通货币和有价证券；10、国家法律法规规章明令禁止寄递的其他物品。
						<br>
					<b>五、验视及安全检查：</b>快递企业收寄员对信件可开拆验视但不得检查内容，对信件以外快件按国家规定当场验视，确认不属禁寄物品且内件性质、品名与所填报内容相符后由收寄员签名。国家禁寄物品、寄件人拒绝验视的，收寄员不得收寄。国家有关司法机关和执法机关出于安全或办理案件需要可依法对快件进行相应检查。<br>
					<b>六、快递服务收费：</b>快递费是指快递企业向寄件人或收件人收取的用于提供快件收取、中转、运输和派送投递等快递服务的费用，收费金额由双方按市场价协商后填写在运单上，月结时可另签收费协议。快件经二次派送投递因收件人原因仍无法投交时由收件人自取或收件人支付每次人民币30元的逾期派送投递费后由快递企业再进行派送投递。<br>
					<b>七、保价及保险：</b>寄件人可自愿对快件向商业保险机构办理保险，<b>对贵重物品和单票内件价值超过人民币壹仟元的快件应尽量向快递企业办理保价。</b>保价快件除支付快递费外还须支付保价费，保价费为申报内件价值的3%（双方另有约定的按约定收取保价费）。保价费须当场支付。未申报保价、未填写内件价值以及未当场支付保价费的视为未保价。<br>
					<b>八、快递及签收：</b>快件按收件人姓名地址当面投递交付和验收。快件外包装破损且收件人查验内件发现存在丢失、损毁或不符等异常情况而拒收时须与派送投递员共同签字注明该情况，收件人拒绝签字的，派送投递员注明情况后退件给寄件人。收件人如不在现场等原因无法签收时，派送投递员可电话联系收件人（寄件人）并征得其同意后可由其指定的人代为签收，代收时派送投递员须核实代收人的身份并记载其身份证件号码或联系电话等必要信息。代收人应及时向收件人转交快件。<br>
					<b>九、投递时限：</b>汽车公路运输（简称汽运）的按《快递服务》国家标准执行，航空运输的由双方另行约定，同城当天快递按运单正面承诺执行。<br>
					<b>十、查询方式：</b>寄件人可自快件交寄之日起一年内持快递运单通过运单上载明的查询电话或网站查询快件信息，逾期后不再受理查询服务。<br>
						运单上印制的查询电话及网站仅用于寄件人查询其所寄快件的信息、协调寄件人与收寄快件的快递企业就快递服务所发生的争议或纠纷。
					<br>
					<b>十一、赔偿标准：</b>在寄递过程中发生快件延误、丢失、损毁、内件不符时，寄件人有权追究快递企业的违约责任或侵权损害赔偿责任（双方另有约定的按约定执行）：<br>
						  1、快件延误的赔偿标准：免除本次快递费（不含保价费）。由于延误导致内件直接价值丧失的，由快递企业按照快件损毁赔偿标准进行赔偿。由于收件人姓名、地址、电话等信息错误或变更以及因收件人外出、无法联系等原因致使快件无法按时交付的，不属于快件延误，快递企业不承担延误责任。<br>
						  2、<b>快件丢失、损毁、内件不符的赔偿标准：</b><br>
						  （1）免除本次快递费（不含保价费）；（2）保价快件按寄件人在运单填写的保价价值即申报内件价值范围内赔偿内件实际损失；<b>（3）未保价快件按寄件人在运单上选填的本次实际支付快递费的合理倍数赔偿，寄件人未选填赔偿标准的，视为同意按本次实际支付快递费的五倍赔偿。</b><br>
					<b>十二、免责声明：</b>快递企业依据《中华人民共和国邮政法》、《快递服务》国家标准等对因下列原因之一造成的快件损失不承担赔偿责任：<br>
							1、不可抗力（保价快件除外）；2、所寄物品本身的自然性质或者合理损耗；3、寄件人或收件人的过错。<br>
					<b>十三、争议解决方式：</b>寄件人与快递企业就快递服务协议发生争议的，可先协商解决；协商不成或不愿意协商的，可依法选择投诉、仲裁或诉讼等方式解决。<br>
					<b>十四、法律适用：</b>本协议适用《中华人民共和国邮政法》、《中华人民共和国合同法》等相关法律法规，未尽事宜按适用法律法规执行。<br>
		</div>
	</div>
	
	<jsp:include page="footer.html" />
</body>
</html>