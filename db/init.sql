--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2024-12-05 19:04:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 41846)
-- Name: clients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clients (
    id integer NOT NULL,
    full_name character varying NOT NULL,
    passport_data character varying NOT NULL,
    marital_status character varying NOT NULL,
    address character varying NOT NULL,
    phone character varying NOT NULL
);


ALTER TABLE public.clients OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 41845)
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clients_id_seq OWNER TO postgres;

--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 214
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clients_id_seq OWNED BY public.clients.id;


--
-- TOC entry 217 (class 1259 OID 41857)
-- Name: credit_application; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.credit_application (
    id integer NOT NULL,
    client_id integer,
    employment_period character varying,
    job_position character varying,
    organization_name character varying,
    desired_amount integer,
    approved_amount integer,
    status character varying,
    payment_term integer
);


ALTER TABLE public.credit_application OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 41856)
-- Name: credit_application_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.credit_application_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.credit_application_id_seq OWNER TO postgres;

--
-- TOC entry 3350 (class 0 OID 0)
-- Dependencies: 216
-- Name: credit_application_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.credit_application_id_seq OWNED BY public.credit_application.id;


--
-- TOC entry 219 (class 1259 OID 41871)
-- Name: credit_contracts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.credit_contracts (
    id integer NOT NULL,
    credit_application_id integer,
    sign_date date,
    signature_status character varying
);


ALTER TABLE public.credit_contracts OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 41870)
-- Name: credit_contracts_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.credit_contracts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.credit_contracts_id_seq OWNER TO postgres;

--
-- TOC entry 3351 (class 0 OID 0)
-- Dependencies: 218
-- Name: credit_contracts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.credit_contracts_id_seq OWNED BY public.credit_contracts.id;


--
-- TOC entry 3183 (class 2604 OID 41849)
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients ALTER COLUMN id SET DEFAULT nextval('public.clients_id_seq'::regclass);


--
-- TOC entry 3184 (class 2604 OID 41860)
-- Name: credit_application id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_application ALTER COLUMN id SET DEFAULT nextval('public.credit_application_id_seq'::regclass);


--
-- TOC entry 3185 (class 2604 OID 41874)
-- Name: credit_contracts id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_contracts ALTER COLUMN id SET DEFAULT nextval('public.credit_contracts_id_seq'::regclass);


--
-- TOC entry 3339 (class 0 OID 41846)
-- Dependencies: 215
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clients (id, full_name, passport_data, marital_status, address, phone) FROM stdin;
10	Озерин Александр Родионович	1822236548	Женат	Советская 25	+76053265415
14	Демин Евгений Игоревич	1565523214	Не женат	Северная 7	+78005553535
\.


--
-- TOC entry 3341 (class 0 OID 41857)
-- Dependencies: 217
-- Data for Name: credit_application; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.credit_application (id, client_id, employment_period, job_position, organization_name, desired_amount, approved_amount, status, payment_term) FROM stdin;
12	14	с 20.05.2020 по 14.06.2022	Менеджер	Яндекс	1000000	800000	Одобрен	300
13	10	123	Тех лид	Макдональс	232113	185690	Одобрен	360
14	14	12	Кассир	Макдональс	2333333	\N	Не одобрен	\N
\.


--
-- TOC entry 3343 (class 0 OID 41871)
-- Dependencies: 219
-- Data for Name: credit_contracts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.credit_contracts (id, credit_application_id, sign_date, signature_status) FROM stdin;
10	12	2024-12-05	Подписан
11	13	2024-12-05	Подписан
12	14	\N	Не подписан
\.


--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 214
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clients_id_seq', 17, true);


--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 216
-- Name: credit_application_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.credit_application_id_seq', 18, true);


--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 218
-- Name: credit_contracts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.credit_contracts_id_seq', 16, true);


--
-- TOC entry 3187 (class 2606 OID 41853)
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- TOC entry 3191 (class 2606 OID 41864)
-- Name: credit_application credit_application_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_application
    ADD CONSTRAINT credit_application_pkey PRIMARY KEY (id);


--
-- TOC entry 3193 (class 2606 OID 41876)
-- Name: credit_contracts credit_contracts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_contracts
    ADD CONSTRAINT credit_contracts_pkey PRIMARY KEY (id);


--
-- TOC entry 3189 (class 2606 OID 41893)
-- Name: clients passport_uniq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT passport_uniq UNIQUE (passport_data);


--
-- TOC entry 3194 (class 2606 OID 41865)
-- Name: credit_application clients_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_application
    ADD CONSTRAINT clients_fk FOREIGN KEY (client_id) REFERENCES public.clients(id);


--
-- TOC entry 3195 (class 2606 OID 41877)
-- Name: credit_contracts credit_application_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credit_contracts
    ADD CONSTRAINT credit_application_fk FOREIGN KEY (credit_application_id) REFERENCES public.credit_application(id);


-- Completed on 2024-12-05 19:04:58

--
-- PostgreSQL database dump complete
--
