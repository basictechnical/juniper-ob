OB=OB||{};OB.ProductCharacteristics={execute:function(b,f){var e,g=b.button.contextView.viewGrid.getSelectedRecords(),c,d=f.getView(b.adTabId).messageBar,j,h,a=true;j=function(l,k,i){this.view=f;isc.UpdateInvariantCharacteristicsPopup.create({productId:k.productId,characteristicList:k.productCharList,actionHandler:"org.openbravo.client.application.event.UpdateInvariantCharacteristicsHandler",view:f}).show();
};c=g[0].id;OB.RemoteCallManager.call(b.actionHandler,{productId:c,action:b.action},{},j);},updateInvariants:function(b,a){b.actionHandler="org.openbravo.client.application.event.UpdateInvariantCharacteristicsHandler";b.adTabId=a.activeView.tabId;b.processId="A832A5DA28FB4BB391BDE883E928DFC5";b.action="INITIALIZE";
OB.ProductCharacteristics.execute(b,a);}};isc.defineClass("UpdateInvariantCharacteristicsPopup",isc.OBPopup);isc.UpdateInvariantCharacteristicsPopup.addProperties({width:400,height:300,title:"Update Characteristics",canDragResize:false,showMinimizeButton:false,showMaximizeButton:false,productId:null,actionHandler:null,characteristicCombos:null,okButton:null,cancelButton:null,initWidget:function(){OB.TestRegistry.register("org.openbravo.client.application.UpdateInvariantCharacteristics.popup",this);
var a=this.view,c=this.params,b;this.characteristicCombos=[];for(b=0;b<this.characteristicList.length;b++){this.characteristicCombos[b]=isc.DynamicForm.create({fields:[{id:this.characteristicList[b].id,name:this.characteristicList[b].name,title:this.characteristicList[b].title,valueMap:this.characteristicList[b].valueMap,defaultValue:this.characteristicList[b].selectedValue,existingProdChValue:this.characteristicList[b].existingProdChValue,height:20,width:255,required:false,type:"_id_17"}]});
}this.okButton=isc.OBFormButton.create({title:OB.I18N.getLabel("OK"),popup:this,action:function(){var j,g,d={},e,h,f={};j=function(l,k,i){i.clientContext.popup.closeClick();i.clientContext.popup.view.refresh(false,false);if(k.message){i.clientContext.popup.view.view.messageBar.setMessage(k.message.severity,null,k.message.text);
}};for(e=0;e<this.popup.items[0].members[0].members.length;e++){h=this.popup.items[0].members[0].members[e];d[h.fields[0].id]=h.values[h.fields[0].name];f[h.fields[0].id]=h.fields[0].existingProdChValue;}OB.RemoteCallManager.call(this.popup.actionHandler,{productId:this.popup.productId,updatedValues:d,existingProdChValues:f,action:"UPDATE"},{},j,{originalView:this.popup.view,popup:this.popup});
}});OB.TestRegistry.register("org.openbravo.client.application.UpdateInvariantCharacteristics.popup.okButton",this.okButton);this.cancelButton=isc.OBFormButton.create({title:OB.I18N.getLabel("Cancel"),popup:this,action:function(){this.popup.closeClick();}});this.items=[isc.VLayout.create({defaultLayoutAlign:"center",align:"center",width:"100%",height:300,overflow:"auto",layoutMargin:10,membersMargin:6,members:[isc.VLayout.create({defaultLayoutAlign:"right",align:"right",layoutMargin:30,membersMargin:6,members:this.characteristicCombos}),isc.HLayout.create({defaultLayoutAlign:"center",align:"center",membersMargin:10,members:[this.okButton,this.cancelButton]})]})];
this.Super("initWidget",arguments);}});