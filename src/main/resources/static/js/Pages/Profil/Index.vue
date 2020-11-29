<template>
  <AppLayout>

    <template #header>
       <p>Profil Page</p>
    </template>
    <div>
       <p>Testt</p>
    </div>

  </AppLayout>

</template>

<script>
	
import AppLayout from '@/Shared/AppLayout';

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
