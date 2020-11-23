<template>
	<div>
		
		<h5>{{name}}</h5>
		<inertia-link href="/update" method="put" as="button" type="button">Update Profil</inertia-link>
	</div>
</template>

<script>
	

export default{

	props:['name'],
	
	data(){
		return{
			
			
		}
	}
}
</script>