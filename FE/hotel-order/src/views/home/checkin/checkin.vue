<template>
  <section class="section">
    <roomTable :roomlist="roomlist" :type="2" />
  </section>
</template>

<script>
import roomTable from "../../../components/roomTable";
export default {
  components: {
    roomTable
  },
  data() {
    return {};
  },
  computed: {
    roomlist() {
      return this.$store.state.roomlist.filter(room => room.status == 0);
    }
  }
};
</script>

<style></style>
