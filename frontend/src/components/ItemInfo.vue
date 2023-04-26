<template>
    <div>
        <h3>상품 제목 : {{ item.itemDTO.itNm }}</h3>
        <p>가격 : {{ item.itemDTO.price }} </p>
    
        <p>옵션
            <select v-model="optCd">
            <option v-for="(option, index) in item.option" :key="index" :value="item.optionNum[index]">
             {{ item.optionName[index] }}
          </option>
        </select>
        </p>
        <p>수량 :
            <select v-model="amount">
                <option v-for="i in 100" :key="i" :value="i - 1">{{ i - 1 }}</option>
            </select>
        </p>

       <button @click="favoriteAdd">찜 하기</button> 
       <button @click="cartAdd">장바구니</button> 
       <button @click="fastOrderConfirm">구매하기</button>

    </div>
</template>

<script>
import eventBus from '@/common/EventBus';
export default {
    props:{
        item : {
            type : Object,
            required: true
        }
    },
    data() {
        return{
            optCd : '',
            amount : '',
        }
    },
    methods : {
        favoriteAdd(){
            const addItem={
                item : this.item,
            };
            eventBus.$emit('favoriteAdd',addItem);
        },
        cartAdd(){
            const addItem={
                itCd : this.item.itCd,
                optCd : this.optCd,
                amount : this.amount,
            };
            eventBus.$emit('cartAdd',addItem);
        },
        fastOrderConfirm(){
            const addItem={
                itCd : this.item.itCd,
                optCd : this.optCd,
                amount : this.amount,
            };
            eventBus.$emit('fastOrderConfirm',addItem);
        }
    }

}
</script>
