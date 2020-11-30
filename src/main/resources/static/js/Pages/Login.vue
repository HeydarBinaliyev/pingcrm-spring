<template>
	<div class="vertical-center">
		 <form>
            <h3>Sign In</h3>

            <div class="form-group">
                <label>Email address</label>
                <input type="email" class="form-control form-control-lg" />
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg" />
            </div>

            <button type="submit" class="btn btn-dark btn-lg btn-block">Sign In</button>

           

         

        </form>
	</div>
</template>

<script>
	
export  default{


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