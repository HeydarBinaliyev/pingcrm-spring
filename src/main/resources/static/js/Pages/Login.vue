<template>
	<div class="vertical-center">
		 <form method="post" action="login">
            <h3>Sign In</h3>

            <div class="form-group">
                <label>Email address</label>
                <input v-model="loginForm.username" name="username" type="text" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input v-model="loginForm.password" name="password"  type="password" class="form-control form-control-lg" />
            </div>
          

            <button type="button" @click="loginn()" class="btn btn-dark btn-lg btn-block">Sign In</button>
        </form>
	</div>
</template>

<script>
	
export  default{

  data(){

    return {

      loginForm: {
        username: '',
        password: ''
      }
    }
  },

  methods:{
      login(){
      
        let that = this;
        axios.post("/login",{username:this.loginForm.username,password:this.loginForm.password}).then(response => {
          console.log("gggggggggg")

        }).catch(function(error){
          if(error.response){
            // The request was made and the server responded with a status code
            // that falls out of the range of 2xx
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);

          }else if(error.request){
            // The request was made but no response was received
            //console.log(error.request);
          }else{
            // Something happened in setting up the request that triggered an Error
            console.log('Error' , error.message);
          }
          //console.log(error.config);
        });
      },

      loginn(){
        let that = this;
        this.$inertia.post("/login?username=" + that.loginForm.username + "&password=" + that.loginForm.password,{});
      }
  }

}
</script>

<style scoped>


.vertical-center {
	display: flex;
	text-align: left;
	justify-content: center;
	flex-direction: column;    
 	width: 30%;
	height: 20%;
	margin-left: 38%;
	margin-top: 5%;
	width: 30%;
	padding-right: 100px;

}

</style>
