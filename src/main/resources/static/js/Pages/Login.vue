<template>
	<div class="vertical-center">
		 <form @submit.prevent="submit">
            <h3>Sign In</h3>

            <div class="form-group">
                <label>Email address</label>
                <input v-model="loginForm.username" name="username" type="text" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input v-model="loginForm.password" name="password"  type="password" class="form-control form-control-lg" />
            </div>
          

            <button type="submit"  class="btn btn-dark btn-lg btn-block">Sign In</button>
        </form>
	</div>
</template>

<script>
	
export  default{

  mounted(){
    
  },

  created(){
  
  },

  data(){

    return {

      loginForm: {
        username: null,
        password: null
      }
    }
  },

  methods:{

      submit() {
        let that = this;
        let data = new FormData();
        data.append('username', this.loginForm.username);
        data.append('password', this.loginForm.password);
        axios.post("/login" , data).then(response=>{
          that.makeToast('success','login is successful');
          that.$inertia.visit("/");
        }).catch(function (error){
           that.makeToast('danger', error.response.data.message);
           console.log(error.response.data);
        });

      },

      makeToast(variant = null, text) {
        this.$bvToast.toast( text , {
          title: `Login attempt`,
          variant: variant,
          solid: true
        })
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
