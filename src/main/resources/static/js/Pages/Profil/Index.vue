<template>
  <AppLayout>

    <template #header>
       <p>Header</p>
    </template>
    <div>
       <p>Testt</p>
    </div>

  </AppLayout>

</template>

<script>
	
import AppLayout from '../Shared/Applayout.vue';

export default{

  components:{
    AppLayout
  },

	props:['name'],
	
	data(){
		return{

			
		}
	},
  created() {

  }
}
</script>
