<template>
  <section class="section">
    <roomTable :roomlist="roomlist" :type="1" />
  </section>
</template>

<script>
import roomTable from "../../../../components/roomTable";
export default {
  components: {
    roomTable
  },
  data() {
    return {
      roomlist: []
    };
  },
  mounted() {
    this.roomlist = this.$store.state.roomlist.filter(room => room.status == 0);
  },
  methods: {}
};
</script>

<style></style>
