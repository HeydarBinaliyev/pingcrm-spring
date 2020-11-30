<template>
  <app-layout>

    <template #header>
      <p>Main Page</p>
    </template>


    <div>
      <inertia-link href="/profil" method="get" as="button" type="button">Goto {{name}} Profil</inertia-link>
      <inertia-link href="/" :only="['type','name']" method="get" as="button" type="button">Load Partial</inertia-link>
    </div>

  </app-layout>
</template>

<script>
	
import AppLayout from "./Shared/AppLayout";
export default{


	props:['name','type'],

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
