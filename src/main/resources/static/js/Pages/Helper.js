export default class Helper
{

	static createRequest(url,method,data=null,params=null,callback){
		let that = this;
			axios({
					method:method,
					url:'/api' +url,
					data:data,
					params:params,
					headers:{}
			}).then(response => {
					callback(response.data);

			}).catch(function(error){
				if(error.response){
					// The request was made and the server responded with a status code
      				// that falls out of the range of 2xx
					console.log(error.response.data);
					console.log(error.response.status);
					console.log(error.response.headers);
					let data = {title:error.response.status, message:error.response.data.message,success:false};
					that.showMessage(data, null, function(){});
				}else if(error.request){
					// The request was made but no response was received
					console.log(error.request);
				}else{
					// Something happened in setting up the request that triggered an Error
					console.log('Error' , error.message);
				}
				//console.log(error.config);
			});

		
	}

	static showMessage(data, messages, callback){
		let type = data.success?"success":"error";
		let text = data.message;
		let title = "";
		if(messages != null)
			title = data.success ? messages.confirmation.operation.success : messages.confirmation.operation.fail;
		else
			title = data.title;

		swal({
			title:title, 
			text:text, 
			icon:type
		}).then(ok =>{
			callback(ok);
		});
	
	}
	static askConfirmation(that, dangerMode, type, callback){
		swal({

			title: that.messages.confirmation.sure,
			text:  that.messages.confirmation.notice,
			icon: type,
			buttons: {
				cancel: that.messages.confirmation.buttons.no,
				ok: that.messages.confirmation.buttons.yes
			},
			dangerMode:dangerMode,
			})
			.then((selection) => {
				callback(selection);
			}
		);
	}

}