<template>
  <section class="section">
    <roomTable :roomlist="roomlist" :type="0" />
  </section>
</template>

<script>
import roomTable from "../../../components/roomTable";
export default {
  components: {
    roomTable
  },
  data() {
    return {
      roomtype: [
        { text: "特价房", value: 0 },
        { text: "标准间", value: 1 },
        { text: "大床房", value: 2 }
      ],
      breakfast: ["否", "是"],
      roomstatus: [
        { text: "空闲", value: 0 },
        { text: "预订中", value: 1 },
        { text: "已入住", value: 2 }
      ],
      roomlist: []
    };
  },
  mounted() {
    this.roomlist = this.$store.state.roomlist;
  },
  methods: {}
};
</script>

<style></style>
