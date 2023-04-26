<template>
  <div>
    
    
    <el-table
        :data="tableData"
        style="text-align: center; margin : 0 auto; width:60%"
        ref="filterTable"
    >
        <el-table-column
      type="index"
      :index="indexMethod" >
    </el-table-column>
        <el-table-column
        label="상품코드"
        width="100">
        <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.itCd }}</span>
        </template>
        </el-table-column>
        <el-table-column label="상품명">
        <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.itNm }}</span>
        </template>
        </el-table-column>
        <el-table-column
        prop="tag"
        label="카테고리"
        width="100"
        :filters="[{ text: 'food', value: 'food' }, { text: 'walking', value: 'walking' }, {text : 'bath', value : 'bath'}]"
        :filter-method="filterTag"
        filter-placement="bottom-end">
        <template slot-scope="scope">
            <el-tag
            :type="scope.row.category === 'food' ? 'primary' : 'success'"
            disable-transitions>{{scope.row.category}}</el-tag>
        </template>
        </el-table-column>
        <el-table-column width="100">
        <template slot-scope="scope" >
            <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">수정</el-button>
        </template>
        </el-table-column>
    </el-table>
    <div style="text-align: center; margin : 0 auto; width:60%">
        <el-button @click="clearFilter">reset all filters</el-button>
    </div>
    <el-pagination
    background
    layout="prev, pager, next" 
    :page-count="this.totalPage" style="margin : 20px auto; text-align: center; " :current-page="this.curPage" 
    @current-change="changePage">
    </el-pagination>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    beforeMount : function(){
        this.ItemList();
    },
    data() {
        return {
            totalPage : 0,
            curPage : 1,
            tableData: [],
            resetText : "RESET"
        }
    },
    methods: {
        handleEdit(index, row) {
            console.log(index, row);
            console.log(row.itCd);
            this.$router.push({path : `/updateItem/${row.itCd}`, props : true});
        },
        handleDelete(index, row) {
            console.log(index, row);

        },
        indexMethod(index) {
            return index +1;
        },
        ItemList : function(){
            var list = this.tableData;
            axios.get("http://localhost:8093/app/admin/itemList/" + this.curPage)
                .then(
                    (res)=>{
                        if(res.data.body != null){
                            console.log(res.data.body);
                            var data = res.data.body;
                            res.data.body.list.map(function(ele){
                                list.push(ele);
                            });
                            var perPage = 8;
                            if(res.data.body.list.length< perPage){
                                this.totalPage = data.totalPage;
                            }else{
                                this.totalPage = data.totalPage+1;
                            }
                            
                        }
                    }
                )
        },
        filterTag(value, row) {
            return row.category === value;
        },
        filterHandler(value, row, column) {
            const property = column['property'];
            return row[property] === value;
        },
        clearFilter() {
            this.$refs.filterTable.clearFilter();
        },
        changePage : function(currentPage){
            console.log(currentPage);
            this.curPage = currentPage;
            this.tableData = [];
            this.ItemList();

        }
    
    }
}
</script>

<style>

</style>