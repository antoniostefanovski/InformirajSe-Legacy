import React from "react";
import '../BlogPreview/BlogPreview.scss';
import cs from '../../assets/sc.jpg';
import Comment from "../Comment/Comment";

export default function BlogPreview(){
    return (
        <div className="blog-preview-main">
            <img src={cs} className="b-p-m-img"></img>
            <div className="b-p-m">
                <h1 className="blog-prev-title">Balkanization е иднината.</h1>
                <div className="blog-prev-title-div">
                    <p className="blog-prev-auth">Автор: user123</p>
                    <p className="blog-prev-date">Креиран на: 01.03.2024</p>
                </div>
            </div>  

            <div className="b-p-butons-div">
                <button type="submit" className="b-p-edit">Измени</button>
                <button type="submit" className="b-p-delete">Избриши</button>
            </div>

            
            <p className="b-p-text">To provide wider colour, context and definition here, Open RAN is a Radio Access Network (RAN) designed to enable equipment and software systems from different vendors to interconnect via standardised, open-specification base stations. The Open Ran Ecosystem Experience (OREX) details NTT Docomo’s work to become a key player in the development of cloud-oriented mobile networks. OREX gets its management quotient from OREX Service Management & Orchestration (SMO).

In February 2018, Docomo established the O-RAN Alliance in partnership with major operators around the world. In March 2020, it launched the world’s first nationwide Open RAN 5G service. In February 2023, the company launched the OREX brand itself. The O-RAN Alliance is an association of telecommunications carriers and equipment vendors working to make next-generation wireless access networks, including 5G, which Dococo has led since its establishment, more scalable, open and intelligent.

Taking advantage of the strengths of both companies, NEC and other OREX Partners (a group of 13 companies: AMD, Dell Technology, Fujitsu, HPE, Intel, Mavenir, NEC, NTT Data, Nvidia, Qualcomm, RedHat, VMware & WindRiver) have been working together to realize Open RAN, including the construction of verification facilities and connection test demonstrations. To accelerate these efforts, NEC will establish a solution provider for the provision of OREX services.

Optimal products & services
A joint venture company will be established in April 2024 to provide OREX services to overseas operators. As one of OREX Partners, the joint venture company will cooperate with each vendor to provide optimal products and services tailored to customer requirements. 

“Through this activity, we will realise the early adoption of high-quality, low-cost, low-power Open RAN, strengthen cooperation with partners around the world and contribute to the creation of a vibrant and open ecosystem. In addition, we will promote the application of the NTT Group’s IOWN initiative to transmission zones of all-photonics networks, the use of low-power servers equipped with optoelectric fusion devices in network equipment,” noted NTT Docomo, in a press statement.

This work will also be carried out in cooperation with the Cognitive Foundation, a group that centrally deploys, configures, coordinates and manages ICT resources at different layers, from the cloud to edge computers, network services and user facilities.

The OREX RU Partners consist of the following seven companies: Dengyo Technology Co. Ltd., HFR, Inc., SOLiD, Electric Industry Co., Ltd., NEC Co., Ltd., Fujitsu Co., Ltd. and Mavenir.

Innovative Optical & Wireless Network (IOWN) 
As previously explained here on Computer Weekly, NTT’s IOWN concept is a network and information processing infrastructure, including terminals, that can provide high-speed, large-capacity communications and enormous computing resources by optimizing each and every piece of information and utilizing innovative technologies, including light.

“The All-Photonics Network introduces photonics-based technologies into everything from networks to terminals, thereby achieving overwhelmingly low power consumption, high quality, large capacity and low delay transmission, which is difficult with current electronics-based technologies,” details NTT, in a technical product statement.

Lessons for software application developers here (could perhaps) include the fact that the next generation of telecommunications networks is still only just being established as high-bandwidth robustly secured low-latency (also often low-power out on the Internet of Things) data communications are enabled across all manner and form factor of devices, so there is still much to build and get excited about. 

Let’s stay connected and dial in.

            </p>

            <Comment />
            <Comment />
            <Comment />
            <Comment />
            <Comment />
            <Comment />
            <Comment />
            <Comment />

            <form className="add-comment-form">
                <h1 className="add-comment-form-h1">Сподели коментар</h1><br></br><br></br>
                <textarea className="comment-textarea"></textarea><br></br><br></br>
                <button type="submit" className="add-comment-btn">Коментирај!</button><br></br><br></br>
            </form>
        </div>
    )
}