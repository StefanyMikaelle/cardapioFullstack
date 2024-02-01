import { Dispatch, SetStateAction, useEffect, useState } from "react";
import { useFoodDataMutate } from "../../hooks/useFoodDataMutate";
import { FoodData } from "../../interface/FoodData";

import "./create-modal.css"

interface InputProps {
    label: string;
    value: string | number;
    updateValue: Dispatch<SetStateAction<string>>;
}

interface ModalProps {
    closeModal():void
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input
                value={value}
                onChange={(event) => updateValue(event.target.value)}
            />
        </>
    );
}

export function CreateModal({closeModal} : ModalProps) {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState<number>(0);
    const [image, setImage] = useState("");
    const {mutate , isSuccess} = useFoodDataMutate();

    const submit = () => {
        const foodData: FoodData = {
            title,
            price, 
            image
        }

        mutate (foodData)
    }

    useEffect (() => {
        if(!isSuccess) return
        closeModal();
    }, [isSuccess])

    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Cadastre um novo item no cardápio</h2>
                <form className="input-container">
                    <Input label="title" value={title} updateValue={setTitle} />
                    <Input label="price" value={price} updateValue={(value) => setPrice(Number(value))} />
                    <Input label="image" value={image} updateValue={setImage} />
                </form>
                <button onClick={submit} className="btn-secondary">
                    Postar
                </button>
            </div>
        </div>
    );
}
