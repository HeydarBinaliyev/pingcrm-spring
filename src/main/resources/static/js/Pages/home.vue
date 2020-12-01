<template>
  <app-layout>

    <template #header>
      <p>Main Page</p>
    </template>


    <div>
      <inertia-link href="/profil" method="get" as="button" type="button">Goto {{user_name}} Profil</inertia-link>
      <inertia-link href="/" :only="['count']" method="get" as="button" type="button">Load Partial</inertia-link>
    </div>

  </app-layout>
</template>

<script>
	
import AppLayout from "./Shared/AppLayout";
export default{


	props:['user_name'],

  components:{
	  AppLayout
  },
	data(){
		return{
			x:"test110000 1"

		}
	}
}
</script>
